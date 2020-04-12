# JavaProfessionalWorkOut
* Work out examples while studying for Java Professional Cert. 


&nbsp;

### Some Learning Notes ###

#### Java I/O ####
* **A stream is a sequence of data**.
* The data source and data destination can be anything that holds, generates, or consumes data.  
It can be disk files, another program, a peripheral device, a network socket, or an array.
&nbsp;

##### Byte Stream #####
* **Top level: abstract class InputStream**  
abstract int read() --> Reads the next byte  
int	read (byte[] b) --> Reads some number of bytes from the input stream and stores them into the buffer array b.  
* Byte streams perform input and output of 8-bit bytes. 
* int read() will read the next byte, and **convert** it to an int (0-255), and return that int. 
* void close(): close() of InputStream class does nothing. The children override this method.
* **Top level: abstract class OutputStream**  
* void write(int b): write a byte to output stream. the int is range 0-255. 
* void close(): close () of OutputStream does nothing. Its children override it.
* void flush(): forces any buffered output bytes to be written out.   
flush() of OutputStream does nothing.  
Buffer children override it. 
* class **FileInputStream** extends InputStream  
It is file I/O byte stream
* Read: returns the next byte it reads.   
The byte can be from 0 to 255.   
returns -1 if no byte is available / the end of the stream is reached.   
This method blocks until input data is available, the end of the stream is detected, or an exception is thrown.   
* Blocking methods in Java are those methods which block the executing thread until their operation finished.  
A famous example of blocking method is InputStream read() method which blocks until all data from InputStream has been read
completely. 
* class **FileOutputStream** extends OutputStream
* Will create file if file does not exist.  
By default will override the file.   
If want to append only: use FileOutputStream(String name, boolean append) constructor. 
&nbsp;

##### Character Stream #####
* Byte stream is low-level I/O. Byte streams should only be used for the most primitive I/O.
* If a file contains character data, the best approach is to use character streams. 
&nbsp;

&nbsp;
----
### Useful links ###
* [About the exam](https://education.oracle.com/java-se-8-programmer-ii/pexam_1Z0-809)
* [Java I/O Oracle Tutorials](https://docs.oracle.com/javase/tutorial/essential/io/index.html)


