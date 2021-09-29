package usefull;

public class Datas {

	/*
	 * громкость звука принимаем так:
	 * musicVolume = (float) (Math.log(d) / Math.log(2) * 6.0f);
	 * 
	 * Делим свободное поле на прямоулольники одинакового размера:
	 * (from CamerOn, KiraLis39, 2020)
	 * 
	 * otherPanelSpace = 60f; // место, занимаемое другими панелями на фрейме
		freeVertical = CurrentFrame.getHeight() - otherPanelSpace;		
		try {maxCamValue = (int) IOM.get(IOM.HEADERS.CONFIG, IOMs.BASIC.MAX_CAMS_VIEW);
		} catch (Exception e) {maxCamValue = 100;} // kоличество желаемых камер на экране
		camS = (CurrentFrame.getWidth() * freeVertical / maxCamValue); // площадь камеры
		sootn = (CurrentFrame.getWidth() / freeVertical); // соотношение сторон свободного места
//		sqrtCamW = Math.sqrt(camS * sootn); // находим ширину камеры
//		sqrtCamH = Math.sqrt(camS / sootn); // находим высоту камеры
//		(1, 4, 9, 16, 25, 36, 49, 64, 81, 100, 121, 144... - наилучшие значения количества камер)
		
		float camWidth = (float) (Math.sqrt(camS * sootn) / 2); // искуственное удвоение по горизонтали (можно убрать)
		setCamDim(camWidth, (float)Math.sqrt(camS / sootn));
				
		wCountGrid = CurrentFrame.getWidth() / getCamDim().width;
		hCountGrid = (int) (freeVertical / getCamDim().height);	
		centerYellowPane.setLayout(new GridLayout(hCountGrid, wCountGrid, 0, 0));
	 */

// get methode name://
//	Thread.currentThread().getStackTrace()[1].getMethodName()
// OR
//	new Object(){}.getClass().getEnclosingMethod().getName()
	
//	st.execute("PRAGMA SQLITE_THREADSAFE = 0;"); //SQLite может быть собран в однопоточном варианте 
//	st.execute("PRAGMA page_size = 4096;"); // размер страницы; страница БД - единица обмена между диском и кэшом, разумно делать равным размеру кластера диска (у меня 4096)
//	st.execute("PRAGMA cache_size = 2000;"); // задать размер кэша соединения в килобайтах, по умолчанию он равен 2000 страниц БД
//	st.execute("PRAGMA encoding = "UTF-8";"); // тип данных БД, всегда используйте UTF-8
//	st.execute("PRAGMA foreign_keys = 1;"); // включить поддержку foreign keys, по умолчанию - ОТКЛЮЧЕНА
//	st.execute("PRAGMA journal_mode = DELETE | TRUNCATE | PERSIST | MEMORY | WAL | OFF;"); // задать тип журнала
//	st.execute("PRAGMA synchronous = 0 | OFF | 1 | NORMAL | 2 | FULL;"); // тип синхронизации транзакции
	
// Instant startTime = Instant.now();
// Duration between = Duration.between(MainClass.getStartTime(), Instant.now());
//	System.out.println("LOADING TIME IS: " + between);
//	System.out.format("%dD, %02d:%02d:%02d.%04d \n", between.toDays(), between.toHours(), between.toMinutes(), between.getSeconds(), between.toMillis());
	
// SimpleTimeZone tz = new SimpleTimeZone(0, "Out Timezone");        
//	TimeZone.setDefault(tz);
// dateFormat.setTimeZone(TimeZone.getTimeZone("+3"));
//	OR
//	TimeZone.setDefault(TimeZone.getTimeZone("GMT+3"));
		
//		byte[] bytes=new byte[14];
//    double myDouble=ByteBuffer.wrap(bytes).getDouble(0);
//    float myFloat=ByteBuffer.wrap(bytes).getFloat(8);
//    short myShort=ByteBuffer.wrap(bytes).getShort(12);
	
//		ExecutorService executor = Executors.newSingleThreadExecutor();
//		executor.submit(() -> {
//			some runnable code...
//		});	
//		executor.shutdown(); //shutdown executor
//		executor.awaitTermination(5, TimeUnit.SECONDS); //ожидая завершения запущенных задач в течение 5 секунд
//		executor.shutdownNow(); //cancel non-finished tasks
	
//		CheckboxGroup cg = new CheckboxGroup();
//		jC1 = new Checkbox("First checker", cg, true);
//		jC2 = new Checkbox("Second checker", cg, false);
//				
//		Choice choice = new Choice();
//		choice.addItem("First");
//		choice.addItem("Second");
//		choice.addItem("Third");
//	
//		Полезные методы класса Choice:
//		countItems() - считать количество пунктов в списке; 
//	  	getItem(int) - возвратить строку с определенным номером в списке; 
//	  	select(int) - выбрать строку с определенным номером; 
//	  	select(String) - выбрать определенную строку текста из списка. 
		
	
//	try {
//		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//		UIManager.setLookAndFeel("com.jgoodies.plaf.plastic.PlasticXPLookAndFeel");
//		UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
//		UIManager.setLookAndFeel(new NimbusLookAndFeel());
//	} catch (Exception e) {"Couldn't get specified look and feel, for some reason.");}
	
//	UIManager.put("Button.font", FONT);
//	UIManager.put("Label.font", FONT);
//	UIManager.put("OptionPane.cancelButtonText", "nope");
//	UIManager.put("OptionPane.okButtonText", "yup");
//	UIManager.put("OptionPane.inputDialogTitle", "Введите свой никнейм:");
	
//		frame.addWindowListener(new WindowListener() {
//			public void windowClosing(WindowEvent e) {
//				Object[] options = {"Да", "Нет!"};
//				int n = JOptionPane.showOptionDialog(
//							e.getWindow(), "Закрыть окно?", "Подтверждение", 
//							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
//							null, options, options[0]);			
//			if (n == 0) {System.exit(0);}
	
	
// 	String command = "cmd /c time";
// 	Process process = Runtime.getRuntime().exec(command);
// 	BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
// 	String line;
// 	while ((line = reader.readLine()) != null) {System.out.println(line);}
		
	
//		recolor:
//		String hex = String.format("%02x%02x%02x%02x", color.getAlpha(), color.getRed(), color.getGreen(), color.getBlue());
//	    int hexColor = (int) Long.parseLong(hex, 16);
//	
//		Image im = Toolkit.getDefaultToolkit().createImage(
//								new FilteredImageSource(tipBack.getSource(), new RGBImageFilter() {
//		    						@Override public final int filterRGB(final int x, final int y, final int rgb) {return rgb & hexColor;}
//		}));

//    int r = (color >> 16) & 0xFF;
//    int g = (color >> 8) & 0xFF;
//    int b = (color >> 0) & 0xFF;
	
//		Color newColor = Color.decode("0xff00ff00");
//		Color color = new Color(0xFF0000);
	
//		Color newColor = new Color(0, 200, 120, 100);
//    System.out.println("0x" + Integer.toHexString(newColor.getAlpha()) + "" + Integer.toHexString(newColor.getRed()) + "" + Integer.toHexString(newColor.getGreen()) + "" + Integer.toHexString(newColor.getBlue()));

	
//		фикс черного полноэкрана. Перед созданием graphDev: 
//    System.setProperty("sun.java2d.noddraw", "true");
//    System.setProperty ("sun.awt.noerasebackground", "true");
//    System.setProperty («sun.java2d.opengl», «true»); // no effect 
//    System.setProperty ("sun.java2d.d3d", "false"); // no effect 
//    System.setProperty ("sun.java2d.d3dtexbpp", "16"); // no effect 
//    System.setProperty ("sun.java2d.ddoffscreen", "false"); // no effect 
//    System.setProperty ("sun.java2d.ddforcevram", "false"); // no effect 
//    System.setProperty ("sun.java2d.accthreshold", "0"); // no effect 
//    System.setProperty ("sun.java2d.translaccel", "true"); // no effect 
//    System.setProperty ("sun.java2d.xrender", "true"); // no effect 
	
	
//		Как создать обработчик нажатия клавиши в JavaFX:
//		объект.setOnKeyTyped(event -> {
//        if (event.getCode() = KeyCode.UP) {
//            // в KeyCode содержатся все коды клавиш
//        }
//    });
}