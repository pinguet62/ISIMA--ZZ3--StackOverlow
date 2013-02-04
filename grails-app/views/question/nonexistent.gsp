<!-- Message indiquant que la question n'existe pas -->



<html>
	<head>
		<meta name="layout" content="main">
		<title>Error - Question</title>
	</head>
	
	<body class="question-page">
		<div id="custom-header"/>
		<div class="container">
			<g:render template="/header" model="[locality: 'question']"/>
			<div id="content">
				<div class="mainbar-full">
					<div class="subheader">
						<h1>Page not found</h1>
					</div>
					<div class="content-page leftcol">
						<p>
							We couldn't find the page you requested. We did, however, find this program.
						</p>
						<ul>
							<li>
								Try <a href="/search?q=where+oh+where+did+the+joel+data+go">searching for similar questions</a>
							</li>
							<li>
								Browse <a href="/questions">recent questions</a>
							</li>
							<li>
								Browse <a href="/tags"> popular tags</a>
							</li>
							<p>
								If you feel something is missing that should be here, <a href="mailto:team@stackoverflow.com">contact us</a>.
							</p>
						</ul>
					</div>
					<div class="rightcol">
						<img width="500" alt="page not found" src="http://sstatic.net/stackoverflow/img/polyglot-404.png"/>
					</div>
				</div>
			</div>
		</div>
		<g:render template="/footer"/>
	</body>
</html>