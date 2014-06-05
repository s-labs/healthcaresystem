<%@ tag language="java" pageEncoding="ISO-8859-1"%>

<!--basic scripts-->

		<!--[if !IE]>-->

		<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>

		<!--<![endif]-->

		<!--[if IE]>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<![endif]-->

		<!--[if !IE]>-->

		<script type="text/javascript">
			window.jQuery || document.write("<script src='assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
		</script>

		<!--<![endif]-->

		<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->

		<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/jquery.validate.js"></script>
		
		
		<script src="${pageContext.request.contextPath}/assets/js/jquery.datetimepicker.js"></script>
		<!--page specific plugin scripts-->

		<!--ace scripts-->

 <script type="text/javascript">
 jQuery(document).ready(function () {
	 jQuery( "#accordion" ).accordion({autoHeight: false});
	 jQuery( ".accordion" ).accordion();
	 jQuery( "#datepicker" ).datepicker({ changeYear: true, yearRange: "1950:2017",dateFormat: "dd/mm/yy",appendText: "(dd/mm/yyyy)"});
	 jQuery( ".datepicker" ).datepicker({ changeYear: true, yearRange: "1950:2017",dateFormat: "dd/mm/yy",appendText: "(dd/mm/yyyy)"});
	 jQuery('#datetimepicker').datetimepicker({ changeYear: true, yearRange: "2014:2017",appendText: "(dd/mm/yyyy)"});
	
});
</script>
<script>
function getXMLHTTP() {
    //function to return the xml http object
    var xmlhttp = false;

    try {
        xmlhttp = new XMLHttpRequest();
    } catch (e) {
        try {
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        } catch (e) {
            try {
                xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
            } catch (e1) {
                xmlhttp = false;
            }
        }
    }

    return xmlhttp;
}
</script>

		<script src="${pageContext.request.contextPath}/assets/js/ace-elements.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/ace.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/jquery-ui-1.10.4.custom.js"></script>

		<!--inline scripts related to this page-->