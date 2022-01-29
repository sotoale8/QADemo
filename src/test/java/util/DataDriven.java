package util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;

public class DataDriven {
    public static ArrayList<String> getData(String nombreCP) {

        ArrayList<String> datos= new ArrayList<String>();
    //Enlazar ruta de excel como un objeto de tipo file
        FileInputStream file = null;
        try {
            file=new FileInputStream(PropertiesDriven.obtenerProperty("rutaExcel"));
        } catch (FileNotFoundException e) {
            System.out.println("Error al ubicar el Archivo "+ e.getStackTrace());
        }
    //Instanciar un objeto de tipo libro excel

        XSSFWorkbook excel=null;

        try {
            excel= new XSSFWorkbook(file);
        }catch (Exception e){
            System.out.println("Error al crear el Excel "+ e.getStackTrace());
        }
        int cantidadHojas= excel.getNumberOfSheets();
        //Buscar Hoja con los datos de Prueba
        for (int i=0;i<cantidadHojas;i++){
        if(excel.getSheetName(i).equalsIgnoreCase(PropertiesDriven.obtenerProperty("hojaExcel"))){
            //Instanciar La hoja encontrada
            XSSFSheet hoja = excel.getSheetAt(i);
            Iterator<Row> iteradorFilas= hoja.iterator();
            //Encontrar la primera Fila
            Row primeraFila= iteradorFilas.next();

            Iterator<Cell> iteratorCelda= primeraFila.cellIterator();
            //Encontrar una celda
            int k=0;
            int columna=0;
            while (iteratorCelda.hasNext()){
                Cell celda= iteratorCelda.next();
                if(celda.getStringCellValue().equalsIgnoreCase(PropertiesDriven.obtenerProperty("tituloCps"))){
                   columna=k;
                   break;
                }
                k++;
            }
            while (iteradorFilas.hasNext()){
                Row r= iteradorFilas.next();
                if (r.getCell(columna).getStringCellValue().equalsIgnoreCase(nombreCP)) {
                    Iterator<Cell> iCeldas = r.cellIterator();
                    while (iCeldas.hasNext()){
                    Cell c= iCeldas.next();
                        if(c.getCellType()== CellType.STRING){
                            //System.out.println(c.getStringCellValue());
                            datos.add(c.getStringCellValue());
                        }else if(c.getCellType()== CellType.NUMERIC){
                            //System.out.println(NumberToTextConverter.toText(c.getNumericCellValue()));
                            datos.add(NumberToTextConverter.toText(c.getNumericCellValue()));
                            }
                        }
                    }
                }
            }
        }

    return  datos;
    }
}
