package com.example.firstdemo

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.firstdemo.databinding.ActivityGoogleMapBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class GoogleMapActivity : AppCompatActivity(), OnMapReadyCallback {


    private lateinit var binding: ActivityGoogleMapBinding
    lateinit var mapFragment: SupportMapFragment
    lateinit var googleMap: GoogleMap
    lateinit var markerPosition: LatLng
    private val LOCATION_PERMISSION_REQUEST = 1


    private fun getLocationAccess() {
        if (ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            googleMap.isMyLocationEnabled = true
        } else
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                LOCATION_PERMISSION_REQUEST
            )
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == LOCATION_PERMISSION_REQUEST) {
            if (grantResults.contains(PackageManager.PERMISSION_GRANTED)) {
                if (ActivityCompat.checkSelfPermission(
                        this,
                        Manifest.permission.ACCESS_FINE_LOCATION
                    ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                        this,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return
                }
                googleMap.isMyLocationEnabled = true
            } else {
                Toast.makeText(
                    this,
                    "User has not granted location access permission",
                    Toast.LENGTH_LONG
                ).show()
                finish()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGoogleMapBinding.inflate(layoutInflater)
        setContentView(binding.root)





        mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment

        mapFragment.getMapAsync(OnMapReadyCallback {
            googleMap = it

            getLocationAccess()

            // Triggered when user click any marker on the map
//            googleMap.addMarker(MarkerOptions().position(location).title("abhishek"))
//            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location, 10f))


//            googleMap.setOnMarkerClickListener(this)
            googleMap.setOnMapClickListener { latlng ->

                 GoogleMap.MAP_TYPE_HYBRID


                googleMap.clear();
                // Animating to the touched position
                googleMap.animateCamera(CameraUpdateFactory.newLatLng(latlng));
                val location = LatLng(latlng.latitude, latlng.longitude)

                binding.btnFind.setOnClickListener(View.OnClickListener {
                    Toast.makeText(
                        this,
                        "Latitude=${latlng.latitude}, Longitude=${latlng.longitude}",
                        Toast.LENGTH_LONG
                    ).show()
                })

                googleMap.addMarker(MarkerOptions().position(location))
            }

        })


    }

    override fun onMapReady(p0: GoogleMap) {
        TODO("Not yet implemented")
    }

//    override fun onMarkerClick(p0: Marker): Boolean {
//
//       markerPosition=  p0.position
//
//        return false
//    }


}