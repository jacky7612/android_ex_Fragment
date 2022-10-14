package com.example.cameratest

import android.media.AudioFormat
import android.media.MediaRecorder
import android.os.Bundle
import android.os.Environment
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AudioFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AudioFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var audioRecorder: AudioRecorder? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_audio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val TAG: String = "OnlyAudioRecorder"
        val AudioSource = MediaRecorder.AudioSource.MIC   // 聲源
        val SampleRate = 16000                            // 頻率
        val Channel = AudioFormat.CHANNEL_IN_MONO         // 單聲道
        val EncodingType = AudioFormat.ENCODING_PCM_16BIT // 數據格式
        val PCMpath =
            Environment.getExternalStorageDirectory().path.toString() + "/Audio/RawAudio.pcm"
        val WAVpath =
            Environment.getExternalStorageDirectory().path.toString() + "/Audio/FinalAudio.wav"
        var bufferSizeInByte = AudioRecorder.getMinBufferSize(SampleRate, Channel, EncodingType)
        audioRecorder = AudioRecorder(AudioSource, SampleRate, Channel, EncodingType, bufferSizeInByte)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AudioFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AudioFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}