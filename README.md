
#TargetDeals

## A simple expandable recyclerview to show the list and query the APIs


The following libraries have been used in this project. 

1.> ButterKnife. 

	Annotate fields with @BindView and a view ID for Butter Knife to find and automatically cast the corresponding view in your layout.

2.> Dagger

	- Dagger is used for dependency injection which is a technique whereby one object (or static method) supplies the dependencies of another object. A dependency is an object that can be used (a service). An injection is the passing of a dependency to a dependent object (a client) that would use it.

3.> Picasso

	- Handling ImageView recycling and download cancelation in an adapter.
    - Complex image transformations with minimal memory use.
    - Automatic memory and disk caching.

4.> Retrofit 

	- Retrofit turns your HTTP API into a Java interface.
    - URL parameter replacement and query parameter support
    - Object conversion to request body (e.g., JSON, protocol buffers)
    - Multipart request body and file upload


Using Recyclerview instead of a ListView. its more flexible and modern. 

All the various components are kept isolated. 

Function in Utils package checks if the internet is connected or not. 

The images are loading in the backgorund, Till then there is a default Target icon , in case of an error in the image loading there will be a placeholder. 

Click on the image to just see an image preview of the product, other details can be added.  

Click on the item to see the details of the product and do futher actions on the product. 

