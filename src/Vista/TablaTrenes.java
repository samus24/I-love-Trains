package Vista;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import Modelo.Tren;

@SuppressWarnings({ "unused", "serial" })
public class TablaTrenes extends AbstractTableModel {

	public String[] columnNames = {"Id",
                                  "Coordenada","Trayecto","Vagones"};

     
	  Object data[][] = {
			  };
	  /**
	   * Default Constructor
	   */
	public TablaTrenes(){

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
		return 4;
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
	public void setInventario(Object valor, int fila, int col){ 
	    data[fila][col] = valor;
	    fireTableDataChanged();
	}
	
	public boolean isCellEditable( int fila,int col ) { 
		    return( false ); 
	}	   

	public void refresh(ArrayList<Tren> trenes) {
		// TODO Auto-generated method stub
		data = new Object[trenes.size()][4];
		for(int i=0; i < trenes.size(); i++){
			data[i][0]=i;
			data[i][1]= trenes.get(i).getCoordenadaInicio().toString();
			data[i][2]=trenes.get(i).getTrayecto();
			data[i][3]= trenes.get(i).getVagones();
		}
		fireTableDataChanged();
	}
}
