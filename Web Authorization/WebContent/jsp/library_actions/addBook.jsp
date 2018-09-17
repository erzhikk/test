<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<br>
<div>
	<div class="container">
		<br>
		<form id="add_book" method="POST" action = "addBook">
		<div class="form-group">
			<label>Name of book</label><input type="email" name="book_name"
				class="form-control" id="inputEmail" placeholder="Name of book" required>
		</div>
		<div class="form-group">
			<label>Author of book</label><input type="email" name="book_author"
				class="form-control" id="inputEmail" placeholder="Author of book" required>
		</div>
		<div class="form-group">
			<label>Price of book</label><input type="email" name="book_price"
				class="form-control" id="inputEmail" placeholder="Price of book" required>
		</div>
		<div class="form-group">
			<label>ISBN code of book</label><input type="email" name="ISBN_code"
				class="form-control" id="inputEmail" placeholder="ISBN code of book" required>
		</div>
		<button type="submit" class="btn btn-primary" style="width: 70px">Save</button>
		<button type="reset" class="btn btn-danger" style="width: 70px">Cancel</button>
		</form>
		
	</div>
</div>
