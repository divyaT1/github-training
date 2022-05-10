const initialState = {
    update: false,
    localStorage: [],
    delData: []

}
export default function (state = initialState, action) {
    console.log("state", state, action.payload);
    switch (action.type) {
        case 'Add_DATA':
            state = {
                ...state,
                localStorage: action.payload
            }
            break;
        case 'DEL_DATA':
            state = {
                ...state,
                delData: action.payload
            }
            break;
            case 'UPDATE' :
                state ={
                    ...state,
                    update :true

                }
                break;
        default:
            return state;

    }

    return state;
}