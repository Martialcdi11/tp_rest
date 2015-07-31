/**
 * 
 */
$(function () {
    function credivemp(employe){
    	var divemp = $('<div>');
    	divemp.attr('class', 'empl');
    	divemp.append($('<div>').text(employe.nom).attr('class', 'emplibelle'))
    	divemp.append($('<div>').text(employe.prenom).attr('class', 'emplibelle'))
    	divemp.append($('<div>').text(employe.matricule).attr('class', 'emplibelle'))
    	
    	return divemp;
    }
    
    function affemployes(employes){
    	$.each(employes, function(index, value) { 
    		$("#lesemployes").append(credivemp(value));
		})
    }
    
    
    function listemp(callbackDone){
    	$.ajax({   
            url: 'http://localhost:8080/restapi/api/employes',    	
            dataType: 'json',
            method: 'GET',
        }).done(function (data) {
        	callbackDone(data);
        }).fail(function (xhr, err) {
            console.log('fail');
            console.log(err)
        });
    }
    	
    function ajoutemp(nom,prenom){
    	$.ajax({   
          url: 'http://localhost:8080/restapi/api/employes/'+nom+'/'+prenom,
     //     dataType: 'json',
          method: 'POST',
          contentType: 'application/json',
//          data: JSON.stringify({
//              titre: file.titre,
//              tags: file.tags,
//              src: file.src,
//          })
      }).done(function (data) {
          console.log('reussi'+data);
          $("#lesemployes").append(credivemp(data));
//    	  callbackDone(data);
      }).fail(function (xhr, err) {
          console.log('fail');
          console.log(err);
          console.log(xhr)
      });
    }
    
//    $('#envoi').on('click', function () {
//    	console.log(this);
//    });
    
    $('#envoi').on('click',function() {
    	var nom = $('#nom').val();
    	var prenom = $('#prenom').val();
    	ajoutemp(nom,prenom);
    	// return false;
      });
    
    
    listemp(affemployes);
});    