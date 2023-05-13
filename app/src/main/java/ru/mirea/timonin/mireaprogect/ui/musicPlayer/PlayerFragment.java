package ru.mirea.timonin.mireaprogect.ui.musicPlayer;

import static android.Manifest.permission.FOREGROUND_SERVICE;
import static android.Manifest.permission.POST_NOTIFICATIONS;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import ru.mirea.timonin.mireaprogect.databinding.FragmentPlayerBinding;

public class PlayerFragment extends Fragment {

    FragmentPlayerBinding binding;
    private int PermissionCode = 200;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentPlayerBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();


        if (ContextCompat.checkSelfPermission(getActivity(), POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED) {
            Log.d(TAG, "onCreateView: ");
        } else {
            ActivityCompat.requestPermissions(getActivity(), new String[]{POST_NOTIFICATIONS, FOREGROUND_SERVICE}, PermissionCode);
        }
        binding.buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent serviceIntent = new Intent(getActivity(), Player.class);
                ContextCompat.startForegroundService(getActivity(), serviceIntent);
            }
        });
        binding.buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().stopService(
                        new Intent(getActivity(), Player.class));
            }
        });

        return binding.getRoot();
    }
}
