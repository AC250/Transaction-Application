# Transaction-Application

<b><h2>ROUTE LIST</h2></b>

<b>POST Request: (For adding)</b> <br>
<pre>
/retailer/add     : name, email <br>
/wholesaler/add   : name, email <br>
/customer/add     : name, email<br>
/transaction/add  : bId, sId, bType, sType, tAmount<br>
</pre>
<b>GET Request: (remove {id} for complete list)</b><br>
<pre>
/transaction/{id}<br>
/retailer/{id}<br>
/wholesaler/{id}<br>
/customer/{id}<br>
</pre>
<b>DELETE Request: (For deleting)</b><br>
<pre>
/transaction/delete/{id}<br>
/retailer/delete/{id}<br>
/cusomer/delete/{id}<br>
/wholesaler/delete/{id}<br>
</pre>
<b>PUT Request: (For updating)</b><br>
<pre>
/transaction/update/{id}  : bId, sId, bType, sType, tAmount<br>
/retailer/update/{id}     : name, email<br>
/wholesaler/update/{id}   : name, email<br>
/customer/update/{id}     : name, email<br>
</pre>
