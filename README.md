# Barcode Reader
![https://github.com/ravikalla/barcode-reader/blob/master/resources/qrcode_1.png](https://github.com/ravikalla/barcode-reader/blob/master/resources/qrcode_1.png)
![https://github.com/ravikalla/barcode-reader/blob/master/resources/codebar_1.png](https://github.com/ravikalla/barcode-reader/blob/master/resources/codebar_1.png)

## Use the java code
 * Clone supporting libraries from "https://github.com/zxing/zxing.git" to your local and install it in Maven
<br/>
<br/>
<i>
cmd> git clone https://github.com/zxing/zxing.git
<br/>
cmd> cd zxing/core
<br/>
cmd> mvn install
<br/>
cmd> cd ../../zxing/javase
<br/>
cmd> mvn install
</i>
<br/>
<br/>
<br/>
 * Import barcode-reader project to local computer
<br/>
<i>
cmd> git clone https://github.com/ravikalla/barcode-reader.git
</i>
<br/>
<br/>
 * Import barcode-reader project to eclipse IDE
<br/>
<br/>
 * Check "in.ravi.barcodereader.BarCodeUtilClient" to read and write barcodes

##Execute the utility directly:
cmd> git clone https://github.com/ravikalla/barcode-reader.git
<br/>
cmd> cd barcode-reader
<br/>
cmd> java -jar target/barcode-reader-jar-with-dependencies.jar "resources/qrcode_1.png"
<br/>
<br/>
O/P: 12345
