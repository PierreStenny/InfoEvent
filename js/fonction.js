$(document).ready(function(){
	chargerPays();
});

function chargerPays(){
	$.get("listePays.jsp",function(rep) {
		$("#pays").html(rep);
		$("#idPays").change(function(){//idPays=id du select dans la page listePays.jsp
			findRegion($(this).val());
		});
	});
}


function findRegion($idPays){
	$.get("listeRegion.jsp?idPays="+$idPays,function(rep) {
		$("#region").html(rep);
		$("#idRegion").change(function(){
			findVille($idPays,$(this).val());
		});
	});
}

function findVille($idPays,$idRegion){
	$.get("listeVille.jsp?idPays="+$idPays+"&idRegion="+$idRegion,function(rep) {
		$("#ville").html(rep);
		
	});
} 