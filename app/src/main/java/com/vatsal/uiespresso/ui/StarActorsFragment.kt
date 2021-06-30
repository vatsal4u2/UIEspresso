package com.vatsal.uiespresso.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vatsal.uiespresso.R
import kotlinx.android.synthetic.main.fragment_star_actors.*

class StarActorsFragment : Fragment() {


    private  var starActors : ArrayList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { args ->
            starActors.addAll(args.get("args_actors") as List<String>)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_star_actors, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setActors()
    }

    private fun setActors(){
        star_actors_text.text = stringBuilderForStarActors(starActors)
    }

    companion object{
        fun stringBuilderForStarActors(actors: ArrayList<String>): String{
            val sb = StringBuilder()
            for(actor in actors){
                sb.append(actor + "\n")
            }
            return sb.toString()
        }
    }

}