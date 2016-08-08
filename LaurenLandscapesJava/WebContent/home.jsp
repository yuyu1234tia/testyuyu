<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<title> ${myapp.title} </title>
	<meta charset="utf8">  
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
   <link href="static/bootstrap.min.css" rel="stylesheet" media="screen">
   <link href="static/bootstrap-responsive.css" rel="stylesheet">
   <link href="static/bootstrap.css" rel="stylesheet">

  <style type="text/css">
	body {
        padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
	
      }
  .preview {
  	float: left;
	margin-right: 20px;
  }    
  .preview .thumb {
    border: 0 none;
    margin-top: 5px;
    width: 252px;
  }
  .outofstock {
  	background-color: red;
  	pointer-events: none;
   	cursor: default;
  }
  a.outofstock {
   color: white;
  }
	
	/* Custom container */
      .container-narrow {
        margin: 0 auto;
        max-width: 900px;
	border-style: solid;
	border-color: transparent;
	background-color: #D8D8D8	;
	z-index: 9;
	height : 100%;
	-moz-border-radius: 15px;
	border-radius: 15px;
	
      }
      .container-narrow > hr {
        margin: 30px 0;
      }

	.sidebar-nav {
        padding: 20px 0;
      }

      @media (max-width: 980px) {
        /* Enable use of floated navbar text */
        .navbar-text.pull-right {
          float: none;
          padding-left: 5px;
          padding-right: 5px;
        }
       
	
  </style>

</head>
<body>

  <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          
          <a class="brand pull-left" href="/home"><em>${myapp.title} </em></a>
	  
          <div class="nav-collapse collapse">
           
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>  <!-- end of div for nav bar-->
  
  <div class="container">
  <!-- <table class="table table-hover">
  <tr> -->
  <div class="hero-unit">
  <div>
  <h2 class="text-center"><em>${myapp.title}</em></h2> </div>
  <br/>
  
 		<p>
		
			Lauren's Lovely Landscapes is a collection of some of her favorite landscapes.  
			If you would like to purchase a print, please <a href="mailto:lauren@example.com">
			e-mail Lauren</a> with the name	of the print.
			
		</p>
		
		<p>
			
			Please check back often to see if we have sales!
			
		</p>
		
		<div>
			<c:forEach var="print" items="${prints}">
			 <c:choose>
				<c:when test"${print.quan < 1}">
					<div class="preview outofstock">
					<a href="printdisp?id=${print.id}" class="outofstock">
					${print.title} - <i><small>(out of stock)</small></i><br>
				</c:when>
			<c:otherwise>
				<div class="preview">
					<a href="printdisp?id=${print.id}">
					${print.title}<br>
			</c:otherwise>
			</c:choose>
					<img src="static/images/${print.imgsrc}" class="thumb">
				</a>
			</div>
			</c:forEach>
			
		</div> 
		<p style="clear:both"></p>
  

 
  </div> <!-- end of the hero-unit-->
  </div> <!-- end of the container-->
  
</body>
</html>
