package Vista;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import Modelo.Senal;

@SuppressWarnings({ "unused", "serial" })
public class TablaSenales extends AbstractTableModel {

	public String[] columnNames = {"Id",
                                  "Coordenada","Estado"};    
	  Object data[][] = {
			  };
	  /**
	   * Default Constructor
	   */
	public TablaSenales(){

	   addTableModelListener(null);	
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		 return( data.length );
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	/**
	 * Get the Column Name.
	 */
    public String getColumnName(int col)
    {
        return columnNames[col];
    }
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return( data[rowIndex][columnIndex] ); 
	}
	
	public boolean isCellEditable( int fila,int col ) { 
		    return( false ); 
	}	   

	public void refresh(ArrayList<Senal> senales) {
		// TODO Auto-generated method stub
		data = new Object[senales.size()][3];
		for(int i=0; i < senales.size(); i++){
			data[i][0]=i;
			data[i][1]= senales.get(i).toString();
			data[i][2]=senales.get(i).getEstado();
		}
		fireTableDataChanged();
	}
}
