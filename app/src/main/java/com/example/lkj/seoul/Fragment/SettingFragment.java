package com.example.lkj.seoul.Fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lkj.seoul.Connection.WebHook;
import com.example.lkj.seoul.KakaoInfoExample;
import com.example.lkj.seoul.Kakao_Login.KakaoSignupActivity;
import com.example.lkj.seoul.Kakao_Login.LoginActivity;
import com.example.lkj.seoul.R;
import com.kakao.auth.ApiResponseCallback;
import com.kakao.auth.AuthService;
import com.kakao.auth.ErrorCode;
import com.kakao.auth.network.response.AccessTokenInfoResponse;
import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.LogoutResponseCallback;
import com.kakao.usermgmt.callback.MeResponseCallback;
import com.kakao.usermgmt.callback.UnLinkResponseCallback;
import com.kakao.usermgmt.response.model.UserProfile;
import com.kakao.util.helper.log.Logger;


public class SettingFragment extends Fragment {

    private Button userInfo;
    private Button userTokenInfo;
    private Button logOut;
    private Button unlink;

    public void SettingFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting, container, false);

        userInfo = (Button) view.findViewById(R.id.userInfo);
        userTokenInfo = (Button) view.findViewById(R.id.userTokenInfo);
        logOut = (Button) view.findViewById(R.id.logOut);
        unlink = (Button) view.findViewById(R.id.unlink);

        userInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserManagement.requestMe(new MeResponseCallback() {
                    @Override
                    public void onFailure(ErrorResult errorResult) {
                        String message = "failed to get user info. msg=" + errorResult;
                        Logger.d(message);

                        ErrorCode result = ErrorCode.valueOf(errorResult.getErrorCode());
                        if (result == ErrorCode.CLIENT_ERROR_CODE) {
                        } else {
                        }
                    }

                    @Override
                    public void onSessionClosed(ErrorResult errorResult) {
                        startActivity(new Intent(getActivity(), LoginActivity.class));
                    }

                    @Override
                    public void onNotSignedUp() {
                    } // 카카오톡 회원이 아닐 시 showSignup(); 호출해야함

                    @Override
                    public void onSuccess(UserProfile userProfile) {  //성공 시 userProfile 형태로 반환
                        Toast.makeText(getActivity(), "id : " + userProfile.getId() + " user nickname : " + userProfile.getNickname() + " user thumbnail photo : " + userProfile.getThumbnailImagePath() + " user profile image : " + userProfile.getProfileImagePath(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        userTokenInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AuthService.requestAccessTokenInfo(new ApiResponseCallback<AccessTokenInfoResponse>() {
                    @Override
                    public void onSessionClosed(ErrorResult errorResult) {
                        new WebHook().execute("token expired", null, null);
                    }

                    @Override
                    public void onNotSignedUp() {
                        // not happened
                    }

                    @Override
                    public void onFailure(ErrorResult errorResult) {
                        String message = "failed to get access token info. msg=" + errorResult;
                        Logger.e(message);
                        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onSuccess(AccessTokenInfoResponse accessTokenInfoResponse) {
                        long userId = accessTokenInfoResponse.getUserId();

                        long expiresInMilis = accessTokenInfoResponse.getExpiresInMillis();

                        Toast.makeText(getActivity(), "this access token for user(id=" + userId + ") expires after " + expiresInMilis + " milliseconds.", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserManagement.requestLogout(new LogoutResponseCallback() {
                    @Override
                    public void onCompleteLogout() {
                        startActivity(new Intent(getActivity(), LoginActivity.class));
                    }
                });
            }
        });

        unlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String appendMessage = getString(R.string.com_kakao_confirm_unlink);
                new AlertDialog.Builder(getActivity())
                        .setMessage(appendMessage)
                        .setPositiveButton(getString(R.string.com_kakao_ok_button),
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        UserManagement.requestUnlink(new UnLinkResponseCallback() {
                                            @Override
                                            public void onFailure(ErrorResult errorResult) {
                                            }

                                            @Override
                                            public void onSessionClosed(ErrorResult errorResult) {
                                                startActivity(new Intent(getActivity(), LoginActivity.class));
                                                getActivity().finish();
                                            }

                                            @Override
                                            public void onNotSignedUp() {
                                                startActivity(new Intent(getActivity(), KakaoSignupActivity.class));
                                                getActivity().finish();
                                            }

                                            @Override
                                            public void onSuccess(Long result) {
                                                startActivity(new Intent(getActivity(), LoginActivity.class));
                                                getActivity().finish();
                                            }
                                        });
                                        dialog.dismiss();
                                    }
                                })
                        .setNegativeButton(getString(R.string.com_kakao_cancel_button),
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                }).show();
            }
        });
        return view;
    }
}
