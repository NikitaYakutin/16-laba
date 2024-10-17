package com.example.sixteen;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class FourFragment extends Fragment {

    private MediaPlayer mediaPlayer;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_four, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (savedInstanceState != null) {
            return;  // Убедитесь, что не пересоздаете фрагмент.
        }
        // Ищем кнопку по id и устанавливаем обработчик нажатий
        Button b2 = view.findViewById(R.id.button2);
        b2.setOnClickListener(v -> {
            // Переход к другой активности
            Intent intent = new Intent(getActivity(), BasicViews.class);
            startActivity(intent);
        });
        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.pie);
        FloatingActionButton msc = view.findViewById(R.id.msc);
        msc.setOnClickListener(v -> {
            if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
                mediaPlayer.start();
            }
        });
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

}
