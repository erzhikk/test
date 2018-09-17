<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<br>
<div>
	<div class="container">
		<br>
		<form id="delete_book" method="POST" action = "addBook">
		<div class="form-group">
			<label>Delete book by name</label><input type="email" name="book_name"
				class="form-control" id="inputEmail" placeholder="Name of book">
		</div>
		<div class="form-group">
			<label>Delete book by author</label><input type="email" name="book_author"
				class="form-control" id="inputEmail" placeholder="Author of book">
		</div>
		<div class="form-group">
			<label>Delete book by price</label><input type="email" name="book_price"
				class="form-control" id="inputEmail" placeholder="Price of book">
		</div>
		<div class="form-group">
			<label>Delete book by ISBN</label><input type="email" name="ISBN_code"
				class="form-control" id="inputEmail" placeholder="ISBN code of book">
		</div>
		<button type="submit" class="btn btn-primary" style="width: 70px">Find</button>
		<button type="reset" class="btn btn-danger" style="width: 70px">Cancel</button>
		</form>
		
	</div>
</div>
