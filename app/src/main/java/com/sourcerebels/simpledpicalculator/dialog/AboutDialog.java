/*
Copyright 2015 Eduardo Manuel Rodríguez Castillo

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */
package com.sourcerebels.simpledpicalculator.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.sourcerebels.simpledpicalculator.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * About dialog
 */
public class AboutDialog extends DialogFragment {

    private static final String ABOUT_DIALOG_TAG = "about";

    @InjectView(R.id.tv_version)
    TextView mTvVersion;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Activity context = getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = LayoutInflater.from(context);

        View layout = inflater.inflate(R.layout.dialog_about, null);

        ButterKnife.inject(this, layout);

        decorate();

        builder.setView(layout);
        return builder.create();
    }


    /**
     * Shows this dialog.
     *
     * @param fm Fragment Manager instance.
     */
    public static void show(FragmentManager fm) {

        DialogFragment dialog = new AboutDialog();
        dialog.show(fm, ABOUT_DIALOG_TAG);
    }

    /**
     * Hides this dialog.
     *
     * @param fm Fragment Manager instance.
     */
    public static void hide(FragmentManager fm) {

        Fragment f = fm.findFragmentByTag(ABOUT_DIALOG_TAG);
        if (f != null) {
            ((DialogFragment) f).dismiss();
        }
    }

    /**
     * Decorates this dialog.
     */
    private void decorate() {

        mTvVersion.setText("v " + getVersionName());
    }

    /**
     * Gets the application versionName.
     *
     * @return Application versionName.
     */
    private String getVersionName() {

        try {

            Context ctx = getActivity();
            PackageInfo pInfo = ctx.getPackageManager().getPackageInfo(ctx.getPackageName(), 0);
            return pInfo.versionName;

        } catch (PackageManager.NameNotFoundException e) {

            return "undefined";
        }
    }
}
