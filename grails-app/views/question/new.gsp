<html>
	<head>
		<meta name="layout" content="main">
		<title>Question</title>
	</head>
	
	<body class="question-page">
		<div id="custom-header"></div>
		<div class="container">
			<g:render template="/header" model="[locality: 'askquestion']"/>
			<div id="content">
				<div id="mainbar" class="ask-mainbar">
					<form id="post-form" class="post-form" method="post" action="/question/create">
						<div class="form-item ask-title">
							<table class="ask-title-table">
								<tbody>
									<tr>
										<td class="ask-title-cell-key">
											<label for="title">Title</label>
										</td>
										<td class="ask-title-cell-value">
											<input class="actual-edit-overlay" type="text" tabindex="100" maxlength="300" autocomplete="off" style="opacity: 1; position: absolute; background-color: white; color: black; width: 610px; height: 16px; line-height: 16px; font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; font-size: 12.8px; text-align: start; border-left: 1px solid rgb(153, 153, 153); border-right: 1px solid rgb(153, 153, 153); border-style: solid; border-color: rgb(153, 153, 153); border-width: 1px;" disabled="disabled"></input>
											<input id="title" class="ask-title-field edit-field-overlayed" type="text" tabindex="100" maxlength="300" name="title" autocomplete="off" style="opacity: 0.4; z-index: 1; position: relative;"></input>
											<span class="edit-field-overlay">what's your programming question? be specific.</span>
										</td>
									</tr>
								</tbody>
							</table>
							<div id="question-suggestions"></div>
						</div>
						<div id="post-editor" class="post-editor">
							<div class="wmd-container">
								<!-- Mise en forme -->
								<!-- Lien, image, ... -->
								<textarea id="wmd-input" class="wmd-input processed" tabindex="101" rows="15" cols="92" name="post-text"></textarea>
								<div class="grippie" style="margin-right: 0px;"></div>
								<div id="draft-saved" class="draft-saved community-option fl" style="margin-top: 8px; height:24px; display:none;">draft saved</div>
								<div id="draft-discarded" class="draft-discarded community-option fl" style="margin-top: 8px; height:24px; display:none;">draft discarded</div>
								<div id="wmd-preview" class="wmd-preview"></div>
								<div></div>
								<div class="edit-block">
									<input id="fkey" type="hidden" value="59825aaf5cdf093f8f2f70e5a7626263" name="fkey"></input>
									<input id="author" type="text" name="author"></input>
								</div>
								<!-- javascript -->
								<div class="form-item">
									<label>Tags</label>
									<input id="tagnames" type="text" tabindex="103" value="" size="60" name="tagnames" style="display: none;"></input>
									<div class="actual-edit-overlay" style="width: 666px; height: 28px; opacity: 1; position: absolute; background-color: white; color: black; line-height: 28px; font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; font-size: 12.8px; text-align: start; border-left: 1px solid rgb(153, 153, 153); border-right: 1px solid rgb(153, 153, 153); border-style: solid; border-color: rgb(153, 153, 153); border-width: 1px;" disabled="disabled">at least one tag such as (ruby jquery django), max 5 tags</div>
									<div class="tag-editor edit-field-overlayed" style="width: 666px; height: 28px; opacity: 0.4; z-index: 1; position: relative;">
										<span style=""></span>
										<input type="text" tabindex="103" style="width: 658px;"></input>
										<span></span>
									</div>
									<span class="edit-field-overlay">
										at least one tag such as (ruby jquery django), max 5 tags
									</span>
								</div>
								<div id="question-only-section">
									<div>
										<h2 class="bottom-notice">
											Would you like to have responses to your questions
											<a id="inbox-notify-1" href="#">sent to you via email</a>
											?
										</h2>
										<!-- javascript -->
										<div class="form-submit cbt">
											<input id="submit-button" type="submit" tabindex="120" value="Post Your Question"></input>
											<a class="discard-question dno" href="#">discard</a>
										</div>
									</div>
								</div>
								
							</div>
							<div class="fl" style="margin-top: 8px; height:24px;"></div>
						</div>
					</form>
				</div>
				<div id="sidebar" class="ask-sidebar">
					<!-- TODO -->
				</div>
			</div>
		</div>
		<g:render template="/footer"/>
	</body>
</html>