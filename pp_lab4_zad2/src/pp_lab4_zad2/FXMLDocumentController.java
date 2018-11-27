package pp_lab4_zad2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Paweł Korczak
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private GridPane grid;
    
    @FXML
    private Label label;
    
    Text textA = new Text("A");
    Text textB = new Text("B");
    Text textC = new Text("C");

    TextField textFieldA = new TextField();
    TextField textFieldB = new TextField();
    TextField textFieldC = new TextField();
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        GridPane secondGrid = new GridPane();
        Scene secondScene = new Scene(secondGrid, 230, 100);
 
        // New window (Stage)
        Stage newWindow = new Stage();
        newWindow.setTitle("Series");
        newWindow.setScene(secondScene);

        // Set position of second window, related to primary window.
        secondGrid.add(createChart(), 0, 0);
        newWindow.show();
       // label.setText("Series added");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
        grid.add(textA, 0, 0);
        grid.add(textFieldA, 1, 0);
        grid.add(textB, 0, 1);
        grid.add(textFieldB, 1, 1);
        grid.add(textC, 0, 2);
        grid.add(textFieldC, 1, 2);
        
        grid.setVgap(5);
        grid.setHgap(5);
        //grid.getChildren().add(createChart());
        //grid.add(createChart(), 1, 8);
        
        
    }    
    protected ScatterChart<Number, Number> createChart() {
        final NumberAxis xAxis = new NumberAxis(-5, 5, 1);
        xAxis.setSide(Side.TOP);
        final NumberAxis yAxis = new NumberAxis(-10, 10, 2);
        yAxis.setSide(Side.RIGHT);
        final ScatterChart<Number,Number> sc = new ScatterChart<Number,Number>(xAxis,yAxis);
        // setup chart
        xAxis.setLabel("X Axis");
        yAxis.setLabel("Y Axis");
        // add starting data
        
        XYChart.Series<Number, Number> series1 = new XYChart.Series<Number, Number>();
        //a)
        series1.setName("f(x)=0");
        for (int i=0; i<50; i++) series1.getData().add(new XYChart.Data<Number, Number>(i, 0));
        
        //b)
        XYChart.Series<Number, Number> series2 = new XYChart.Series<Number, Number>();
        series2.setName("f(x)=-x^2");
        for (int i=-5; i<5; i++) series2.getData().add(new XYChart.Data<Number, Number>(i, -Math.pow(i, 2)));
        
        //c)
        XYChart.Series<Number, Number> series3 = new XYChart.Series<Number, Number>();
        series3.setName("f(x)=x^2-x+3");
        for (int i=-50; i<50; i++) series3.getData().add(new XYChart.Data<Number, Number>(i, Math.pow(i, 2)-i+3));
        
        sc.getData().addAll(series1, series2, series3);
        
        return sc;
    }
        protected ScatterChart<Number, Number> createChart(TextField a, TextField b, TextField c) {
            int A = Integer.parseInt(a.getText());
            int B = Integer.parseInt(b.getText());
            int C = Integer.parseInt(c.getText());
            
            final NumberAxis xAxis = new NumberAxis(-5, 5, 1);
            xAxis.setSide(Side.TOP);
            final NumberAxis yAxis = new NumberAxis(-10, 10, 2);
            yAxis.setSide(Side.RIGHT);
            final ScatterChart<Number,Number> sc = new ScatterChart<Number,Number>(xAxis,yAxis);
            // setup chart
            xAxis.setLabel("X Axis");
            yAxis.setLabel("Y Axis");
            XYChart.Series<Number, Number> series1 = new XYChart.Series<Number, Number>();
            for (int i=-5; i<5; i++) series1.getData().add(new XYChart.Data<Number, Number>(i, A*Math.pow(i, 2)+B*i+C));
            
            sc.getData().add(series1);
            return sc;
        }
        
      
        
}
