<nav class="navbar navbar-default navbar-fixed-top"
		style="padding-top:20px">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="/user">My Home Library</a>
		</div>
		<ul class="nav nav-navbar">
			<form action="search" method="post">
				<li>
					<div class="search-bar col-md-2">
						<input type="text" id="searchbar" name="searchbar"
							class="search-bar-input col-md-10" placeholder="Search" required>
						<a id="a">
							<button name="button" value="search" class="search-bar-button col-md-2" type="submit">
								<span class="glyphicon glyphicon-search"></span>
							</button>
						</a>
					</div>
				</li>
				<!-- <li class="dropdown col-md-2">
					<div class="col-md-4">
						<select class="selectpicker" multiple
							title="Select Search Options" data-actions-box="true"
							name="select">
							<option>Title</option>
							<option>Author</option>
						</select>
					</div></li>
				<li class="dropdown col-md-2">
					<div class="col-md-4">
						<select class="selectpicker" multiple
							title="Select Language" data-actions-box="true"
							name="selectlanguage">
							<option>English</option>
							<option>Spanish</option>
						</select>
					</div>
				</li> -->
			</form>
			<li class="dropdown col-md-2 pull-right"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">${user.firstName} <span
					class="glyphicon glyphicon-user"></span> <span class="caret"></span>
			</a>
				<ul class="dropdown-menu">
					<li><form action="logout" method="post">
							<button class="btn btn-default col-md-12" type="submit"
								name="button" value="logout">LogOut</button>
						</form></li>
				</ul></li>
		</ul>
	</div>
	</nav>