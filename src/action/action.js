export const setDataintoLocalStorage = (data) => {
    return (dispatch) => {
   localStorage.setItem("Add", JSON.stringify(data));
   //var localData = JSON.parse(localStorage.getItem("Add"));
      dispatch({
        type: "Add_DATA",
        payload: data
      })
    
    }
  }

  export const deleteDataintoLocalStorage = (data) => {
    return (dispatch) => {
     localStorage.setItem("delete", JSON.stringify(data));
   //var localData = JSON.parse(localStorage.getItem("Add"));
      dispatch({
        type: "DEL_DATA",
        payload: data
      })
    
    }
  }