var titreZone = document.getElementById("zoneJSON");
ajaxGet("http://toutcine.herokuapp.com/cine/all", function (reponse) {
    var articles = JSON.parse(reponse);
    var data_length = articles.length;
        for (var i = 0; i < data_length; i++) {

            var paragraphe = document.createElement("p");
            paragraphe.innerHTML = "<div class='item'>"+
        "<div class='w3l-movie-gride-agile w3l-movie-gride-agile1'>"+
            "<a href='single.jsp' class='hvr-shutter-out-horizontal'>"+
            "<img src="+articles[i]["affiche"]+" title='album-name' class='img-responsive'/>"+
                "<div class='w3l-action-icon'><i class='fa fa-play-circle' aria-hidden='true'></i></div></a>"+
            "<div class='mid-1 agileits_w3layouts_mid_1_home'>"+
                "<div class='w3l-movie-text'>"+
                    "<h6><a href='single.jsp'>"+articles[i]["titre"]+"</a></h6></div>"+
                "<div class='mid-2 agile_mid_2_home'><p>"+articles[i]["anneeDeSortie"]+"</p>"+
                    "<div class='block-stars'>"+
                        "<ul class='w3l-ratings'>"+
                            "<li><i class='fa fa-star' aria-hidden='true'></i></li>"+
                            "<li><i class='fa fa-star' aria-hidden='true'></i></li>"+
                            "<li><i class='fa fa-star' aria-hidden='true'></i></li>"+
                            "<li><i class='fa fa-star' aria-hidden='true'></i></li>"+
                            "<li><i class='fa fa-star-half-o' aria-hidden='true'></i></li>"+
                        "</ul></div>"+
                "<div class='clearfix'></div></div></div>"+
        "<div class='ribben'><p>NEW</p>"+
        "</div></div></div>";

             titreZone.appendChild(paragraphe);
        }
});
