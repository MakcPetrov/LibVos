package petrov

import javax.swing.*

class BookListWindow internal constructor() : JFrame() {
    init {
        defaultCloseOperation = WindowConstants.DISPOSE_ON_CLOSE
        setSize(600, 400)
        setLocationRelativeTo(null)
        isResizable = true//� ����� �����
        title = Set.books

        Set.out("BookList created")
    }//BookList

}
