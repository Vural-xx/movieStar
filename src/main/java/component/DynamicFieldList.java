package component;

import java.util.List;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIData;
import javax.faces.component.UINamingContainer;

import com.mysql.jdbc.Field;

import model.Feld;
import model.Film;
import model.Mitwirkende;

@FacesComponent(value="dynamicFieldList") // To be specified in componentType attribute.
@SuppressWarnings({"rawtypes", "unchecked"}) // We don't care about the actual model item type anyway.
public class DynamicFieldList extends UINamingContainer {

    private UIData table;

    public void add() {
        ((List) getAttributes().get("value")).add(new Feld("test"));
    }

    public void remove() {
        ((List) getAttributes().get("value")).remove(table.getRowData());
    }

    public UIData getTable() {
        return table;
    }

    public void setTable(UIData table) {
        this.table = table;
    }

}