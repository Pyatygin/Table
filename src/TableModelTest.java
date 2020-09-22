import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.ArrayList;

//Создание модели таблицы
public class TableModelTest implements TableModel {

    // создание списка с объектами киндергадрен
    public ArrayList<Kindergarten> list;

    // конструктор для создания
    public TableModelTest(ArrayList<Kindergarten> list) {
        this.list = list;
    }

    //добавление в список нового объекта киндергарден
    public void add(Kindergarten kindergarten) {
        list.add(kindergarten);
    }

    //удаление из списка объекта киндергарден по индексу
    public void delete(int index){
        list.remove(index);
    }

    //информация о количестве строк в списке с объектами киндергарден
    @Override
    public int getRowCount() {
        return list.size();
    }

    // информация о количестве столбцов в списке с объектами киндергарден
    @Override
    public int getColumnCount() {
        return 4;
    }

    //Назваие столбцов
    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0: return "Имя";
            case 1: return "Текущее кол-во детей";
            case 2: return "Максимальное кол-во детей";
            case 3: return "Ежемесячный платеж";
        }
        return "Non";
    }

    // возвращает тип данных в столбце списка с объектами киндергадрен
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    // влзвращает информацию, была ли отредактирована эта ячейка
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    // возвращает значение из конкретной ячейки таблицы
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Kindergarten kindergarten = list.get(rowIndex);

        switch (columnIndex) {
            case 0: return kindergarten.getName();
            case 1: return kindergarten.getmanNow();
            case 2: return kindergarten.getMax();
            case 3: return kindergarten.getMoney();
        }
        return null;
    }

    // устанавливает значение для конкретной ячейки таблицы
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    //добавление слушателя в TableModel
    @Override
    public void addTableModelListener(TableModelListener l) {

    }
    //удаление слушателя из TableModel
    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
}
