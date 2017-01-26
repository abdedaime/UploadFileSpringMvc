<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="resources/bootstrap.min.css" />

<title>Upload File</title>

</head>
<body>
          <div class="container">
            <div class="row">
                <div class="col-md-8">
                    <h1>Spring 4 MVC - File Upload Example</h1>
                    <form method="post" action='upload' enctype="multipart/form-data">
                        <div class="form-group">
                            <label for="file1">File </label>
                            <input type="file" name="file" id="file1">
                        </div>
                        <button type="submit" class="btn btn-success">Submit</button>
                    </form>
                </div>
            </div>
        </div>

</body>
</html>