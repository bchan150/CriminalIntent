package com.example.criminalintent;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import androidx.fragment.app.DialogFragment;

import java.io.File;

public class PhotoViewFragment extends DialogFragment {
    private static final String ARG_PHOTO = "photo";
    private ImageView mPhotoView;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        File mPhotoFile = (File)getArguments().getSerializable(ARG_PHOTO);

        View v = LayoutInflater.from(getActivity())
                .inflate(R.layout.dialog_photo, null);

        mPhotoView = (ImageView)v.findViewById(R.id.dialog_image);
        updatePhotoView(mPhotoFile);

        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .create();
    }

    public static PhotoViewFragment newInstance(File file) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_PHOTO, file);
        PhotoViewFragment fragment = new PhotoViewFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private void updatePhotoView(File mPhotoFile) {
        Bitmap bm = PictureUtils.getScaledBitmap(
                mPhotoFile.getPath(), getActivity());
        mPhotoView.setImageBitmap(bm);
    }
}
