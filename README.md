# onlinestore
A simple spring based e-commerce backend which is based out of Java Spring boot framework.

supported APIs are :
1. /products - get or post products
2. /add2cart - add products to cart
3. /checkout - process with payment to buy products in cart
4. /orderplaced - approve order after payment comfirmation.


Payload for posting products :```
  [{
    "productId" : "100",
    "productName" : "Bajaj mixer 750 watt 2020",
    "productPrice" : 5000.50,
    "productType" : "electronics",
    "productSize" : "free size",
    "sellerName" : "amazon"
  },
  {
    "productId" : "200",
    "productName" : "Bajaj mixer 1000 watt 2020",
    "productPrice" : 6000.50,
    "productType" : "electronics",
    "productSize" : "free size",
    "sellerName" : "amazon"
  }]```

  
Payload for adding products to cart :```
  {
    "userId" : 1000,
    "productIds" : [100]
  }```
  
  
Payload for checking out :```
  {
    "userId" : 1000,
    "orderId" : null,
    "accessToken" : "dummy"
  }```

Payload for placing order by approving it :```
  {
    "userId" : 1000,
    "orderId" : 1,
    "accessToken" : "dummy"
  }```
