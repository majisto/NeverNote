# NeverNote

Spring Boot app to emulate a simple REST backend for Evernote.  Make sure you have Maven installed for it to work correctly.  

Simple CRUD operations are allowed on notes inside of notebooks.  To get started, build the project and run 

> mvn spring:boot-run

Once the server is running on port 8080, you can begin interacting with the application.  You first want to create a notebook.

> POST localhost:8080/notebook/create

The request body is formulated as... 

> {"name":"test"}

This will return a number, which is the ID for the notebook.  You will use this in subsequent calls for adding notes to tell which notebook to use.  In future releases, you will be allowed to send the notebook name.

To create a note, call

> POST localhost:8080/notes/add

and the request body is

> {
	"noteBook" : 0,
	"title" : "Note2",
	"body" : "it's a body!",
	"tags": ["tag1", "tag1"]
}

where *noteBook* is the ID number returned from creation, *title* is the title is the note, *body* is self explanatory, and *tags* is a list of tags for that note.

To retrieve a notebook,

> GET localhost:8080/notebook/get?id=0

To retrieve a note based on a tag, 

> GET localhost:8080/notes/tags?id=0&tag=tag1

Deletion is handled with a request body

> DELETE localhost:8080/notes/delete 

> {
	"noteBookID" : 0,
	"title": "Note2"
}

To update a note, use

> PUT localhost:8080/notes/update

Request body is the same as adding a note.
