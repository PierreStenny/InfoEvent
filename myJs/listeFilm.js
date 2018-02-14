var titreZone = document.getElementById("listeFilm");
ajaxGet("http://toutcine.herokuapp.com/cine/all", function (reponse) {
    var articles = JSON.parse(reponse);
    var data_length = articles.length;
        for (var i = 0; i < data_length; i++) {
            
            var debut = document.createElement("tr");
             
             var tdaffiche = document.createElement("td");
tdaffiche.innerHTML = "<td class='w3-list-img'><img src="+articles[i]["affiche"]+" /> <span>"+articles[i]["titre"]+"</span></td>"
             
             
             var tdannee = document.createElement("td");
             tdannee.innerHTML = "<td>"+articles[i]["anneeDeSortie"]+"</td>";
             var tdduree = document.createElement("td");
             tdduree.innerHTML = "<td>"+articles[i]["duree"]+"</td>";
             var tdgenre = document.createElement("td");
             tdgenre.innerHTML = "<td>"+articles[i]["genre"]+"</td>";
             var tdrealisateur = document.createElement("td");
             tdrealisateur.innerHTML = "<td>"+articles[i]["realisateur"]+"</td>";
             var tdacteur = document.createElement("td");
             tdacteur.innerHTML = "<td class='w3-list-info'><a href='comedy.jsp'>"+articles[i]["acteur"]+"</a></td>";
            var fin = document.createElement("tr");

            titreZone.appendChild(debut);
            
            titreZone.appendChild(tdaffiche);
            titreZone.appendChild(tdannee);
            titreZone.appendChild(tdduree);
            titreZone.appendChild(tdgenre);
            titreZone.appendChild(tdrealisateur);
            titreZone.appendChild(tdacteur);
            titreZone.appendChild(fin);
             
        }
});
