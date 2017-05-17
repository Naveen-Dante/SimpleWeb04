<footer>
	<form>
		<select id="language" name="language" onchange="submit()">
				<option value="en_US" ${sessionScope.language == 'en_US' ? 'selected' : ''}>English</option>
				<option value="es_ES" ${sessionScope.language == 'es_ES' ? 'selected' : ''}>Español</option>
			</select>
		</form>
</footer>