<html>
<head>
    <title>
        Welcome To Java and Cassandra :)
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Tutorial For Connecting Java to Cassandra">
    <meta name="author" content="Dipak Malla">
    <link rel="stylesheet" type="text/css" href="static/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="static/css/bootstrap-responsive.min.css">
    <style>
        body {
            padding-top: 60px;
        }
        .form-signin {
            max-width: 300px;
            padding: 19px 29px 29px;
            margin: 0 auto 20px;
            background-color: #fff;
            border: 1px solid #e5e5e5;
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
            border-radius: 5px;
            -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
            -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
            box-shadow: 0 1px 2px rgba(0,0,0,.05);
        }
        .form-signin .form-signin-heading,
        .form-signin .checkbox {
            margin-bottom: 10px;
        }
        .form-signin input[type="text"],
        .form-signin input[type="password"] {
            font-size: 16px;
            height: auto;
            margin-bottom: 15px;
            padding: 7px 9px;
        }

    </style>
</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="brand" href="#">Java Cassandra</a>
            <div class="nav-collapse collapse">
                <ul class="nav">
                    <li class="active"><a href="insert">Insert</a></li>
                    <li><a href="update">Update</a></li>
                    <li><a href="delete">Delete</a></li>
                    <li><a href="select">Select</a></li>
                </ul>
            </div><!--/.nav-collapse -->
        </div>
    </div>
</div>

<div class="container">
    <h2>Insert Record To Cassandra</h2>
    <form class="form-signin" method="post" action="insert">
        <%
            String succ = (String)request.getAttribute("succ");
            //String datas = (String)request.getAttribute("datas");
            String error = (String)request.getAttribute("error");
            if(succ != null){ %>
        <div class="alert alert-success">
            Record Inserted Successfully
        </div>
        <% } %>
        <% if(error != null)
        { %>
        <div class="alert alert-error">
            Oops record could not be inserted.
        </div>
        <% } %>

        <input type="text" class="input-block-level" name="myname" placeholder="Name">
        <input type="text" class="input-block-level" name="email" placeholder="Email">
        <input type="text" class="input-block-level" name="phone" placeholder="Phone">
        <button class="btn btn-primary" type="submit">Insert</button>
    </form>
</div>
<script type="text/javascript" src="static/js/bootstrap.min.js"></script>
</body>
</html>
