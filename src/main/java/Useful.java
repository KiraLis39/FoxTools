final class Useful {
    /*
     * XP убийство моба = 100 * (10 + LVL моба — LVL игрока)/(10 + LVL игрока). На
     * первом уровне нужно убить 10 мобов своего уровня, на десятом — двадцать.
     */

// Assert:
// assert !string.equals("") : "Нельзя передавать пустую строку в printEngine!";

// Проверить цифра ли символ:
// Predicate<String> startsWithDigit = s -> !s.isEmpty() && Character.isDigit(s.charAt(0));

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

// // Как просчитать процент масштабирования экрана:
//	(20 - 18) / 20 = 10%
//
// deltaW = (1680 - 1024) / 1680;
// deltaW = 656 / 1680;
// deltaW = 0.39; (3.9%)
// PIXEL to PERCENT: y = (monitorWidht - x) / monitorWidht;
//
//	Width = 1680 - 1680 * 0.39; (1024 px)
// PERCENT to PIXEL: x = monitorWidht - monitorWidht * y;

//	// Как взять шрифт, которого нет у пользователя на компе, если он есть в папке с программой:
//		try {upCardsFont = Font.createFont(Font.TRUETYPE_FONT, new File("./resources/fonts/papyrus.ttf"));} catch (Exception e) {e.printStackTrace();}
//		upCardsFont = upCardsFont.deriveFont(getWidth() * 0.04f)
//		g2D.setFont(upCardsFont);

//	  byte[] bytes=new byte[14];
//    double myDouble=ByteBuffer.wrap(bytes).getDouble(0);
//    float myFloat=ByteBuffer.wrap(bytes).getFloat(8);
//    short myShort=ByteBuffer.wrap(bytes).getShort(12);

//		ExecutorService executor = Executors.newSingleThreadExecutor();
//		executor.submit(() -> {
//
//		});
//		executor.shutdown(); //shutdown executor
//		executor.awaitTermination(5, TimeUnit.SECONDS); //ожидая завершения запущенных задач в течение 5 секунд
//		executor.shutdownNow(); //cancel non-finished tasks

//		CheckboxGroup cg = new CheckboxGroup();
//		jC1 = new Checkbox("First checker", cg, true);
//		jC1.setForeground(Color.GREEN.brighter());
//		jC2 = new Checkbox("Second checker", cg, false);
//		jC2.setForeground(Color.GREEN.brighter());
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

//		public static final Font FONT = new Font("Verdana", Font.PLAIN, 11);
//
//		try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); //(new NimbusLookAndFeel());
//		} catch (Exception ex) {ex.printStackTrace();}
//
//		UIManager.put("Button.font", FONT);
//		UIManager.put("Label.font", FONT);

//		frame.addWindowListener(new WindowListener() {
//		public void windowClosing(WindowEvent event) {
//			Object[] options = { "Да", "Нет!" };
//			int n = JOptionPane.showOptionDialog(event.getWindow(), "Закрыть окно?",
//		            	"Подтверждение", JOptionPane.YES_NO_OPTION,
//		            	JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
//
//			if (n == 0) {
//		        event.getWindow().setVisible(false);
//		        System.exit(0);
//		    }

//		System.out.println("Key pressed: " + e.getKeyText(e.getKeyCode()) + " (" + e.getKeyCode() + ")" + e.getModifiers());

    // String command = "cmd /c time";
    // try {
    // 	Process process = Runtime.getRuntime().exec(command);
    // 	BufferedReader reader = new BufferedReader(new InputStreamReader(
    // 	process.getInputStream()));
    // 	String line;
    // 	while ((line = reader.readLine()) != null) {
    // 	System.out.println(line);
    // }
    // reader.close();
    // } catch (IOException e) {e.printStackTrace();}

//		backIm2.getScaledInstance(1024, 768, 2);
//		setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.0f));
//		setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//		setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
//		setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
//		setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
//		setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
//		setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
//		setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
//		setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);

    // Save as new image
//		ImageIO.write(BufferedImage, "PNG", new File(path, "combined.png"));

    //recolor:
//		String hex = String.format("%02x%02x%02x%02x", color.getAlpha(), color.getRed(), color.getGreen(), color.getBlue());
//	    int hexColor = (int) Long.parseLong(hex, 16);
//
//		Image im = Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(tipBack.getSource(), new RGBImageFilter() {
//		    @Override
//		    public final int filterRGB(final int x, final int y, final int rgb) {return rgb & hexColor;}
//		}));

//    int r = (color >> 16) & 0xFF;
//    int g = (color >> 8) & 0xFF;
//    int b = color & 0xFF;

//		Color newColor = Color.decode("0xff00ff00");
//		Color color = new Color(0xFF0000);

//		Color newColor = new Color(0, 200, 120, 100);
//    System.out.println("0x" + Integer.toHexString(newColor.getAlpha()) + "" + Integer.toHexString(newColor.getRed()) + "" + Integer.toHexString(newColor.getGreen()) + "" + Integer.toHexString(newColor.getBlue()));

    //фикс черного полноэкрана. Перед созданием graphDev:
//    System.setProperty("sun.java2d.noddraw", "true");
//    System.setProperty ("sun.awt.noerasebackground", "true");
//    System.setProperty («sun.java2d.opengl», «True»); // no effect
//    System.setProperty ("sun.java2d.d3d", "false"); // no effect
//    System.setProperty ("sun.java2d.d3dtexbpp", "16"); // no effect
//    System.setProperty ("sun.java2d.ddoffscreen", "false"); // no effect
//    System.setProperty ("sun.java2d.
//    System.setProperty ("sun.java2d.ddforcevram", "false"); // no effect
//    System.setProperty ("sun.java2d.accthreshold", "0"); // no effect
//    System.setProperty ("sun.java2d.translaccel", "true"); // no effect
//    System.setProperty ("sun.java2d.xrender", "True"); // no effect

//Как создать обработчик нажатия клавиши в JavaFX? Я новичок в Java,поэтому помогайте.
//Допустим юзер нажал стрелку вверх,и X круга увеличивается на 5.
//объект.setOnKeyTyped(event -> {
//        if (event.getCode() = KeyCode.UP) { // в KeyCode содержатся все коды клавиш
//            // какое-нибудь действие
//        }
//    });

    /*
     * XP убийство моба = 100 * (10 + LVL моба — LVL игрока)/(10 + LVL игрока). На
     * первом уровне нужно убить 10 мобов своего уровня, на десятом — двадцать.
     */

	/*
	 * громкость звука принимаем так:
	 * musicVolume = (float) (Math.log(d) / Math.log(2) * 6.0f);
	 * 
	 * Делим свободное поле на прямоугольники одинакового размера:
	 * (from CamerOn, KiraLis39, 2020)
	 * 
	 * otherPanelSpace = 60f; // место, занимаемое другими панелями на фрейме
		freeVertical = CurrentFrame.getHeight() - otherPanelSpace;		
		try {
		  maxCamValue = (int) IOM.get(IOM.HEADERS.CONFIG, IOMs.BASIC.MAX_CAMS_VIEW);
		} catch (Exception e) {
		  maxCamValue = 100;
		} // kоличество желаемых камер на экране
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


//	st.execute("PRAGMA SQLITE_THREADSAFE = 0;"); //SQLite может быть собран в однопоточном варианте 
//	st.execute("PRAGMA page_size = 4096;"); // размер страницы; страница БД - единица обмена между диском и кэшом, разумно делать равным размеру кластера диска (у меня 4096)
//	st.execute("PRAGMA cache_size = 2000;"); // задать размер кэша соединения в килобайтах, по умолчанию он равен 2000 страниц БД
//	st.execute("PRAGMA encoding = "UTF-8";"); // тип данных БД, всегда используйте UTF-8
//	st.execute("PRAGMA foreign_keys = 1;"); // включить поддержку foreign keys, по умолчанию - ОТКЛЮЧЕНА
//	st.execute("PRAGMA journal_mode = DELETE | TRUNCATE | PERSIST | MEMORY | WAL | OFF;"); // задать тип журнала
//	st.execute("PRAGMA synchronous = 0 | OFF | 1 | NORMAL | 2 | FULL;"); // тип синхронизации транзакции


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

    /*
    new SimpleDateFormat("dd MMMM, EEEE"); // 05 июля, пятница

    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSS X"); // 2019-07-05 21:27:26 +03
     */

    /*
    ...



    * Симметрическая разность двух коллекций - это множество элементов, одновременно не принадлежащих обоим исходным коллекциям.
    <T> Collection<T> symmetricDifference(Collection<T> a, Collection<T> b) {
        // Объединяем коллекции.
        Collection<T> result = new ArrayList<>(a);
        result.addAll(b);

        // Получаем пересечение коллекций.
        Collection<T> intersection = new ArrayList<>(a);
        intersection.retainAll(b);

        // Удаляем элементы, расположенные в обоих коллекциях.
        result.removeAll(intersection);

        return result;
    }

     */
}
