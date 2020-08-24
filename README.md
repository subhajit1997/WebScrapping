WebScrapping

Scrapping "https://news.ycombinator.com" Data such as url,title,content_writer,points,time is performed in : WebScrappingService.java

Storing and retrieving of data is performed in : MongoDbService.java

Main Class to run program :WebScrappingApplicatin.java

Output:

Start: DocumentInsertIfExist() Collection sampleCollection selected successfully

Collection Data(Relation1) & MetaData(Relation2) sucessfully updated

All Data(Relation1) collection Data with url,title:

<--ALL Documents-->

All MetaData(Relation2) collection Data with url,title,content_writer,lastModified,points:

<--ALL Documents-->

No new documents found to update (<--Number of new documents inserted-->) End: DocumentInsertIfExist()
