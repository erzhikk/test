<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<body class="bg-secondary">
	<div class="container">
		
		<form id="add_book" method="POST" action = "addBook">
		<div class="form-group">
			<label>Name of book</label><input type="email" name="book_name"
				class="form-control" id="inputEmail" placeholder="Name of book">
		</div>
		<div class="form-group">
			<label>Author of book</label><input type="email" name="book_author"
				class="form-control" id="inputEmail" placeholder="Author of book">
		</div>
		<div class="form-group">
			<label>Price of book</label><input type="email" name="book_price"
				class="form-control" id="inputEmail" placeholder="Price of book">
		</div>
		<div class="form-group">
			<label>ISBN code of book</label><input type="email" name="ISBN_code"
				class="form-control" id="inputEmail" placeholder="ISBN code of book">
		</div>
		<button type="submit" class="btn btn-primary">Save</button>
		<button type="reset" class="btn btn-danger">Cancel</button>
		</form>
		
	</div>
</body>
