/**
 * Descripción: Fragment para mostrar la imagen seleccionada
 * Autor: Assistant
 * Fecha creación: 24/09/2024
 * Fecha última modificación: 24/09/2024
 */
// Descripción: Interacción con Imágenes versión Fragments.
// Autor: Fabricio Gabriel Carrazco Arana
// Fecha de creación: 21/09/2024
// Última modificación: 24/09/2024
package com.example.seagradece

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class ImageFragment : Fragment() {
    private lateinit var imageView: ImageView
    private lateinit var backButton: Button
    private lateinit var imageNameText: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_image, container, false)

        imageView = view.findViewById(R.id.selectedImageView)
        backButton = view.findViewById(R.id.backButton)
        imageNameText = view.findViewById(R.id.imageNameText)

        val selectedImage = arguments?.getString("selectedImage")
        imageNameText.text = selectedImage

        val imageResource = when(selectedImage) {
            "Montaña" -> R.drawable.mountain
            "Playa" -> R.drawable.beach
            "Bosque" -> R.drawable.forest
            "Ciudad" -> R.drawable.city
            "Desierto" -> R.drawable.desert
            else -> R.drawable.default_image
        }
        imageView.setImageResource(imageResource)

        backButton.setOnClickListener {
            activity?.fragmentManager?.popBackStack()
        }

        return view
    }

    companion object {
        fun newInstance(selectedImage: String): ImageFragment {
            val fragment = ImageFragment()
            val args = Bundle()
            args.putString("selectedImage", selectedImage)
            fragment.arguments = args
            return fragment
        }
    }
}