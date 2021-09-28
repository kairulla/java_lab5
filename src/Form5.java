import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Form5 extends javax.swing.JFrame {

    public class MyPicture extends JPanel { // КЛАСС РИСОВАНИЯ СВОЕЙ КАРТИНКИ

        Graphics2D canvas;   // Класс рисования
        BufferedImage buff;  // Буферное изображение
        int x = 360; // Константа размера полотна по х
        int y = 350; // Константа размера полотна по y

        MyPicture() {
            // Создаем буферное полотно для рисования размером x-y
            buff = new BufferedImage(x, y, BufferedImage.TYPE_INT_RGB);
            // Создаем двустороннюю связь между буферным изображением и классом рисования
            canvas = (Graphics2D) buff.getGraphics();

//            canvas.setPaint(Color.GRAY); // Устанавливаем цвет рисования серым
//            canvas.fillRect(0, 0, x, y); // Заливаем полотно для рисования
//
//            canvas.setPaint(Color.BLACK);  // Устанавливаем цвет рисования черным
//            canvas.drawOval(100, 80, 90, 90);  // Отрисовываем большой овал

//            canvas.drawArc(100, 115, 90, 30, 180, 180); // Отрисовываем дугу по середине овала
//            //рисуем два мелньких круга сверху и снизу
//            canvas.drawOval(140, 70, 10, 10);
//            canvas.drawOval(140, 170, 10, 10);
            
            //my figure
            canvas.drawArc(58, 71, 120, 148, 92, 176); //ext (x, y, width, height, begin, end)            
            canvas.drawArc(74, 70, 105, 150, 8, 314); //inter (x, y, width, height, begin, end)            
            canvas.drawArc(178, 112, 80, 125, 200, 309); //inter/key (x, y, width, height, begin, end)            
            canvas.drawArc(194, 116, 70, 120, 86, -180); //ext/key (x, y, width, height, begin, end)
            canvas.drawArc(120, 114, 8, 10, 90, 90); //duga/key (x, y, width, height, begin, end)
            canvas.drawArc(220, 159, 20, 31, 0, 360); //dira/key (x, y, width, height, begin, end)
            canvas.drawArc(227, 159, 20, 31, 112, 128); //dira/key/duga (x, y, width, height, begin, end)
            canvas.drawLine(120, 120, 120, 175); //(x1, y1, x2, y2) vertical 90*
            canvas.drawLine(124, 114, 186, 136); //(x1, y1, x2, y2) \1
            canvas.drawLine(120, 120, 184, 142); //(x1, y1, x2, y2) \2
            canvas.drawLine(120, 175, 180, 196); //(x1, y1, x2, y2) \3
            
            
            
            //устанавливаем стиль и пишим текст
//            canvas.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 40));
//            canvas.drawString("Java!", 85, 50);

            try {
                // При помощи созданной функции заливки закрашиваем две части главного овала
                // и два маленьких кружка
                fill(110, 110, Color.GRAY, Color.WHITE);
                fill(140, 150, Color.GRAY, Color.RED);
                fill(145, 75, Color.GRAY, Color.RED);
                fill(145, 175, Color.GRAY, Color.WHITE);
            } catch (Exception ex) {
            }
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g); // Отрисовываем панель и компоненты на ней
            g.drawImage(buff, 0, 0, this); // Отрисовываем буфер с нашим изображением на панель
        }

        private void fill(int x, int y, Color bgcolor, Color color) throws Exception {
            // Заливка фигур методом ромба, параметры: х,y- координаты начала заливки, 
            // bgcolor-цвет который надо закрашивать, color-цвет которым надо закрашивать 
            ArrayList<Point> point = new ArrayList<>(); // Создаем динамический массив точек
            point.add(new Point(x, y)); // Добавляем начальную точку в массив
            Color oldColor = canvas.getColor(); // Сохраняем старый цвет рисования
            canvas.setPaint(color); //ставим цвет закраски
            while (point.size() > 0) { // Пока в массиве имеются точки для закрашивания
                Point p = point.remove(0); // Считываем координаты первой точки, и удаляем ее из массива
                x = p.x;
                y = p.y;
                if (bgcolor.getRGB() == buff.getRGB(x, y)) { // Если ее надо нам закрасить
                    canvas.drawLine(x, y, x, y); // Закрашиваем точку
                    point.add(new Point(x + 1, y)); // Добавляем точку справа
                    point.add(new Point(x - 1, y)); // Добавляем точку слева
                    point.add(new Point(x, y + 1)); // Добавляем точку снизу
                    point.add(new Point(x, y - 1)); // Добавляем точку сверху
                }
            }
            canvas.setPaint(oldColor); //ставим старый цвет рисования
            repaint();  // Перерисовываем изображение
        }
    }

    public Form5() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new MyPicture();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Лабораторная 5");
        setIconImage(java.awt.Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon.png")));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/task.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 360, 301, 47);

        jPanel1.setBackground(new java.awt.Color(244, 243, 234));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 360, 350);

        setSize(new java.awt.Dimension(369, 467));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form5.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form5.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form5.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form5.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form5().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
