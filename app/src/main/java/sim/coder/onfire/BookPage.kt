package sim.coder.onfire

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_book_page.*



class BookPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_page)

        val shared=getSharedPreferences("onfire", Context.MODE_PRIVATE)

        val edit= shared.edit()
        val number =shared.getInt("numPage",0)




        pdf.fromAsset("onfire.pdf")
            .defaultPage(number)
            .enableDoubletap(true)
            .enableSwipe(true)
            .swipeHorizontal(false)
            .enableAnnotationRendering(true)
            .onPageChange { page, pageCount ->
                edit.putInt("numPage",page)
                edit.commit()

            }
            .load()



    }





}
