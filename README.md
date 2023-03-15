For reproduce https://github.com/quarkusio/quarkus/discussions/31807

To reproduce run
./gradlew quarkusDev

In browser open
http://localhost:8080/q/swagger-ui/#/Bug%20Reproduce%20Service/post_data

See error section
Resolver error at paths./data.post.requestBody.content.multipart/form-data.schema.properties.fileStream.allOf.0.$ref
Could not resolve reference: Could not resolve pointer: /components/schemas/File does not exist in document
Resolver error at paths./data.post.requestBody.content.multipart/form-data.schema.properties.fileStream.$ref
Could not resolve reference: Could not resolve pointer: /components/schemas/File does not exist in document

If you open
http://localhost:8080/q/swagger-ui/#/Bug%20Reproduce%20Service/post_upload1 then
you see uploadButton works. But if implement saving file looks like InputStream is uploaded as text, not binary file
