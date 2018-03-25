<!DOCTYPE HTML>
<html>
	<head>
		<title>Cognizant Bank</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,300italic,600|Source+Code+Pro" rel="stylesheet" />
		<script src="html5shiv.js" type="text/javascript"></script>
		<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>		
		<script src="skel.js">
		{
			prefix: 'style',
			preloadStyleSheets: true,
			resetCSS: true,
			boxModel: 'border',
			grid: { gutters: 30 },
			breakpoints: {
				wide: { range: '1200-', containers: 1140, grid: { gutters: 50 } },
				narrow: { range: '481-1199', containers: 960 },
				mobile: { range: '-480', containers: 'fluid', lockViewport: true, grid: { collapse: true } }
			}
		}
		</script>
</head>
	<body>
		<div id="header_container">		
		    <div class="container">
			<!-- Header -->
				<div id="header" class="row">
					<div class="4u">
						<div class="transparent">
							<h1><a href="IndexPage.jsp">Cognizant <span class="header_colour">Bank</span></a></h1>
							<br>
							<h2>Banking without Boundaries</h2>
					    </div>
					</div>
					
					<nav id="main-nav" class="8u">
						<ul>
							<li><a href="LoanType.jsp">Apply Loan</a></li>
							<li><a href="TransactionScreen.jsp">Transactions</a></li>
							<li><a  class="active" href="dataController">Update Profile</a></li>
							<li><a href="statementPage.jsp">Statement Generation</a></li>
							<li><a  href="Logout.jsp">Logout</a></li>
						</ul>
					</nav>
				</div>
			</div>	
        </div>