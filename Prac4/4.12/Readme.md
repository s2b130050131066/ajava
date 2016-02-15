
4.12 Time Updater in Servlet
----------------------------
In this program we are going to make one program on servlet which will keep on updating the time in every second and the result will be displayed to you.
To make this servlet firstly we need to make a class named TimeUpdater.  The name of the class should be such that it becomes easy to understand what the program is going to do. Call the method getWriter() method of the response object which will return a PrintWriter object. Use the method getHeader() of the response object to add a new header. We can also use setHeader() in place of getHeader(). The setHeader() method overrides the previous set header. Now by using the PrintWriter object display the result on the browser.


![op 4 12](https://cloud.githubusercontent.com/assets/16942766/13045598/4814ccee-d3fa-11e5-9d2e-a8734e304a54.jpg)
![op 4 12 1](https://cloud.githubusercontent.com/assets/16942766/13045599/4e1bf4fa-d3fa-11e5-9d81-b85fb0cef1c7.jpg)
