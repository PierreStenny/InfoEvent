var titreZone = document.getElementById("ficheFilm");
ajaxGet("http://toutcine.herokuapp.com/cine/all", function (reponse) {
    var articles = JSON.parse(reponse);
    var data_length = articles.length;
        var paragraphe = document.createElement("p");
            paragraphe.innerHTML = "<div class='song-info'>"+
        "<h3>"+articles[data_length-1]["titre"]+"</h3></div>"+
        "<div class='video-grid-single-page-agileits'>"+
        "<div data-video='dLmKio67pVQ' id='video'> <img src="+articles[data_length-1]["affiche"]+" width='700' height='700'/></div></div>"+
        "<div class='row'>"+
        "<div class='page-header text-left'>"+
        "<h3>Description</h3></div>"+
                "<div class='col-md-12'>"+
                    articles[data_length-1]["description"]+
                    "<br><br></div>"+
                "<div class='col-md-12 text-left'>"+
                    "<table>"+
                        "<tr>"+
                            "<td><b>Durée</b></td>"+
                            "<td>&nbsp;&nbsp;:&nbsp;&nbsp;</td>"+
                            "<td>"+articles[data_length-1]["duree"]+"</td>"+
                        "</tr><tr>"+
                            "<td><b>Réalisateur</b></td>"+
                            "<td>&nbsp;&nbsp;:&nbsp;&nbsp;</td>"+
                            "<td>"+articles[data_length-1]["realisateur"]+"</td>"+
                        "</tr><tr>"+
                            "<td><b>Acteur</b></td>"+
                            "<td>&nbsp;&nbsp;:&nbsp;&nbsp;</td>"+
                            "<td>"+articles[data_length-1]["acteur"]+"</td>"+
                        "</tr>"+
                    "</table>"+
                "</div>"+
        "</div>";

        titreZone.appendChild(paragraphe);
    
});
