$(function() {
	var isLogined = true;
	if(!isLogined){
		$("a#productList").hide();
		$("a#myAccountInfo").hide();
	}else{
		$("a#productList").show();
		$("a#myAccountInfo").show();
		$("a#login").hide();
	}
});

function clickLogin() {
   location.replace("./login")
}

function clickHome() {
    $(".content").load("jsp/content.jsp");
}

function clickProductList() {
    $(".content").load("jsp/productlist.jsp");
}

// Product list filter
function myFunction() {
    // Declare variables
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("myInput");
    filter = input.value.toUpperCase();
    table = document.getElementById("myTable");
    tr = table.getElementsByTagName("tr");

    // Loop through all table rows, and hide those who don't match the search query
    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[1];
        if (td) {
            txtValue = td.textContent || td.innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}