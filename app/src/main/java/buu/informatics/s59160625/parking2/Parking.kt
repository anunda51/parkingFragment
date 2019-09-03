package buu.informatics.s59160625.parking2


import android.graphics.Color
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.fragment_parking.*

/**
 * A simple [Fragment] subclass.
 */
class Parking : Fragment() {

    var room1: Array<String> = arrayOf("","","")
    var room2 : Array<String> = arrayOf("","","")
    var room3 : Array<String> = arrayOf("","","")
    var num = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_parking, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        value.visibility = View.INVISIBLE
        btn1_button.setBackgroundColor(Color.parseColor("#FF1BEB04"))
        btn2_button.setBackgroundColor(Color.parseColor("#FF1BEB04"))
        btn3_button.setBackgroundColor(Color.parseColor("#FF1BEB04"))
        btn1_button.setOnClickListener {
            num = 1
            showValue()
        }
        btn2_button.setOnClickListener {
            num = 2
            showValue()
        }
        btn3_button.setOnClickListener {
            num = 3
            showValue()
        }
        update_button.setOnClickListener {
            update()
        }
        delete_button.setOnClickListener {
            delete()
        }
        setHasOptionsMenu(true)
    }

    private fun showValue(){
        value.visibility = View.VISIBLE
        if(num==1){
            carid_edit.setText(room1[0])
            brand_edit.setText(room1[1])
            fullname_edit.setText(room1[2])

        }
        if(num==2){
            carid_edit.setText(room2[0])
            brand_edit.setText(room2[1])
            fullname_edit.setText(room2[2])
        }
        if(num==3){
            carid_edit.setText(room3[0])
            brand_edit.setText(room3[1])
            fullname_edit.setText(room3[2])
        }
    }

    private fun update(){
        if(num==1){
            if(carid_edit.text.toString() != "" && brand_edit.text.toString() != "" && fullname_edit.text.toString() != ""){
                room1[0] = carid_edit.text.toString()
                room1[1] = brand_edit.text.toString()
                room1[2] = fullname_edit.text.toString()
                btn1_button.text = room1[0]
                btn1_button.setBackgroundColor(Color.parseColor("#FFE60808"))
                value.visibility = View.INVISIBLE
            }else{
                value.visibility = View.INVISIBLE
            }
        }
        if(num==2){
            if(carid_edit.text.toString() != "" && brand_edit.text.toString() != "" && fullname_edit.text.toString() != ""){
                room2[0] = carid_edit.text.toString()
                room2[1] = brand_edit.text.toString()
                room2[2] = fullname_edit.text.toString()
                btn2_button.text = room2[0]
                btn2_button.setBackgroundColor(Color.parseColor("#FFE60808"))
                value.visibility = View.INVISIBLE
            }else{
                value.visibility = View.INVISIBLE
            }
        }
        if(num==3){
            if(carid_edit.text.toString() != "" && brand_edit.text.toString() != "" && fullname_edit.text.toString() != ""){
                room3[0] = carid_edit.text.toString()
                room3[1] = brand_edit.text.toString()
                room3[2] = fullname_edit.text.toString()
                btn3_button.text = room3[0]
                btn3_button.setBackgroundColor(Color.parseColor("#FFE60808"))
                value.visibility = View.INVISIBLE
            }else{
                value.visibility = View.INVISIBLE
            }
        }
    }
    private fun delete(){
        if(num==1){
            room1[0] = ""
            room1[1] = ""
            room1[2] = ""
            reset()
            btn1_button.text = "Empty"
            btn1_button.setBackgroundColor(Color.parseColor("#FF1BEB04"))
        }
        if(num==2){
            room2[0] = ""
            room2[1] = ""
            room2[2] = ""
            reset()
            btn2_button.text = "Empty"
            btn2_button.setBackgroundColor(Color.parseColor("#FF1BEB04"))
        }
        if(num==3){
            room3[0] = ""
            room3[1] = ""
            room3[2] = ""
            reset()
            btn3_button.text = "Empty"
            btn3_button.setBackgroundColor(Color.parseColor("#FF1BEB04"))
        }
    }
    private fun reset(){
        carid_edit.setText("")
        brand_edit.setText("")
        fullname_edit.setText("")
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.option_info, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,
            view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }
}
