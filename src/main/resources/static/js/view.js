function boardDelete(){
    const no = document.getElementById("no").value;
    fetch("/board/"+no, {method: 'delete'})
        .then(res=>
            {
                alert('삭제완료');
                location.href = "/";
            }

        )
        .catch(err=>
            {
                alert('삭제실패');
            }
        )
    
}

function back(){
    history.back();
}