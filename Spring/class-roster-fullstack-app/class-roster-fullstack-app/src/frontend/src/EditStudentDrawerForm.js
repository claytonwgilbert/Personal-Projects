import {Drawer, Form, Button, Col, Row, Input, Select, Spin} from 'antd';
import {useAppContext} from "./context/appContext";
import {useEffect} from "react";

const { Option } = Select;

function EditStudentDrawerForm(){
    const {
        showEditDrawer,
        closeEditDrawer,
        isSubmitting,
        editStudent,
        editStudentFailed,
        studentToEdit,
    } = useAppContext();

    const [form] = Form.useForm();

    useEffect(() => {
        form.setFieldsValue({
            name : studentToEdit.name,
            email : studentToEdit.email,
            gender : studentToEdit.gender,
        });
    }, [studentToEdit.name])

    return (
        <Drawer
            title="Edit Student"
            width={720}
            onClose={closeEditDrawer}
            visible={showEditDrawer}
            bodyStyle={{paddingBottom: 80}}
            footer={
                <div style = {{textAlign: 'right'}}>
                    <Button onClick={closeEditDrawer} style={{marginRight: 8}}>
                        Close
                    </Button>
                </div>
            }>
            <Form layout="vertical"
                  onFinish={editStudent}
                  onFinishFailed={editStudentFailed}
                  form={form}
                  hideRequiredFailed>
                <Row gutter={16}>
                    <Col span={12}>
                        <Form.Item
                            name="name"
                            label="Name"
                            rules={[{required: true, message: 'Please enter student name'}]}>
                            <Input placeholder="Please enter student name"/>
                        </Form.Item>
                    </Col>
                    <Col span={12}>
                        <Form.Item
                            name="email"
                            label="Email"
                            rules={[{required: true, message: 'Please enter student email'}]}
                        >
                            <Input placeholder="Please enter student email"/>
                        </Form.Item>
                    </Col>
                </Row>
                <Row gutter={16}>
                    <Col span={12}>
                        <Form.Item
                            name="gender"
                            label="Gender"
                            rules={[{required: true, message: 'Please select student gender'}]}
                        >
                            <Select placeholder="Please select student gender">
                                <Option value="MALE">Male</Option>
                                <Option value="FEMALE">Female</Option>
                                <Option value="OTHER">Other</Option>
                            </Select>
                        </Form.Item>
                    </Col>
                </Row>
                <Row gutter={16}>
                    <Col span={12}>
                        <Form.Item>
                            <Button type="primary" htmlType="submit">
                                Submit
                            </Button>
                        </Form.Item>
                    </Col>
                </Row>
                <Row>
                    {isSubmitting && <Spin />}
                </Row>
            </Form>
        </Drawer>
    );
}

export default EditStudentDrawerForm;